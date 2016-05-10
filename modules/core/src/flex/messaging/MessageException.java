/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package flex.messaging;

import java.util.Map;

import flex.messaging.log.Log;
import flex.messaging.log.LogCategories;
import flex.messaging.log.LogEvent;
import flex.messaging.messages.ErrorMessage;
import flex.messaging.messages.Message;
import flex.messaging.util.ExceptionUtil;
import flex.messaging.util.PropertyStringResourceLoader;
import flex.messaging.util.ResourceLoader;
import flex.messaging.util.StringUtils;

/**
 * The MessageException class is the basic exception type used throughout
 * the server.  This class is extended to support more specific exception types.
 */
public class MessageException extends LocalizedException
{
    //--------------------------------------------------------------------------
    //
    // Static Constants
    //
    //--------------------------------------------------------------------------

    // Message exception code strings.
    public static final String CODE_SERVER_RESOURCE_UNAVAILABLE = "Server.ResourceUnavailable";


    static final long serialVersionUID = 3310842114461162689L;

    //--------------------------------------------------------------------------
    //
    // Constructors
    //
    //--------------------------------------------------------------------------

    /**
     * Default constructor.
     */
    public MessageException()
    {
    }

    /**
     * Construct a message specifying a ResourceLoader to be used to load localized strings.
     *
     * @param loader
     */
    public MessageException(ResourceLoader loader)
    {
        super(loader);
    }

    /**
     * Constructor with a message.
     *
     * @param message The detailed message for the exception.
     */
    public MessageException(String message)
    {
        setMessage(message);
    }

    /**
     * Constructs a new exception with the specified message and the <code>Throwable</code> as the root cause.
     *
     * @param message The detailed message for the exception.
     * @param t The root cause of the exception.
     */
    public MessageException(String message, Throwable t)
    {
        setMessage(message);
        setRootCause(t);
    }

    /**
     * Constructs a new exception with the specified <code>Throwable</code> as the root cause.
     *
     * @param t The root cause of the exception.
     */
    public MessageException(Throwable t)
    {
        String rootMessage = t.getMessage();
        if (rootMessage == null)
            rootMessage = t.toString();
        setMessage(rootMessage);
        setRootCause(t);
    }

    //--------------------------------------------------------------------------
    //
    // Properties
    //
    //--------------------------------------------------------------------------

    //----------------------------------
    //  code
    //----------------------------------


    protected String code;

    /**
     * Returns the code of the exception.
     *
     * @return Code of the exception.
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Sets the code of the exception.
     *
     * @param code Code of the exception.
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    //----------------------------------
    //  defaultLogMessageIntro
    //----------------------------------

    /**
     * Returns the default initial text for use in the log output generated by <code>logAtHingePoint()</code>.
     *
     * @return the default initial text for use in the log output generated by <code>logAtHingePoint()</code>.
     */
    public String getDefaultLogMessageIntro()
    {
        return "Error handling message: ";
    }

    //----------------------------------
    //  extendedData
    //----------------------------------


    protected Map extendedData;

    /**
     * Returns the extended data of the exception.
     *
     * @return The extended data of the exception.
     */
    public Map getExtendedData()
    {
        return extendedData;
    }

    /**
     * Sets the extended data of the exception.
     *
     * @param extendedData The extended data of the exception.
     */
    public void setExtendedData(Map extendedData)
    {
        this.extendedData = extendedData;
    }

    //----------------------------------
    //  errorMessage
    //----------------------------------


    protected ErrorMessage errorMessage;

    /**
     * Returns the error message of the exception.
     *
     * @return The error message of the exception.
     */
    public ErrorMessage getErrorMessage()
    {
        if (errorMessage == null)
        {
            errorMessage = createErrorMessage();
        }
        return errorMessage;
    }

    /**
     * Sets the error message of the exception.
     *
     * @param errorMessage The error message of the exception.
     */
    public void setErrorMessage(ErrorMessage errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    //----------------------------------
    //  logStackTraceEnabled
    //----------------------------------

    /**
     * Indicates whether logging of this exception should include a full stack trace or not.
     * Default is true.
     *
     * @see #logAtHingePoint(Message, ErrorMessage, String)
     * @return true if the logging stack traces is enabled.
     */
    public boolean isLogStackTraceEnabled()
    {
        return true;
    }

    //----------------------------------
    //  logged
    //----------------------------------

    protected boolean logged;

    /**
     * Indicates whether this exception has already been logged
     * by a call to <code>logAtHingPoint()</code>.
     * Manual logging for an exception can use <code>setLogged(true)</code>
     * to suppress any further automatic logging of the exception.
     *
     * @return true if the exception has been logged; otherwise false.
     */
    public boolean isLogged()
    {
        return logged;
    }

    /**
     * Records whether this exception has been logged.
     *
     * @param value true if the exception has been logged; otherwise false.
     */
    public void setLogged(boolean value)
    {
        logged = value;
    }

    //----------------------------------
    //  peferredLogLevel
    //----------------------------------

    /**
     * Returns the preferred log level for this exception instance.
     * The default value is <code>LogEvent.ERROR</code>.
     *
     * @see #logAtHingePoint(Message, ErrorMessage, String)
     * @return the preffered log level.
     */
    public short getPreferredLogLevel()
    {
        return LogEvent.ERROR;
    }

    //----------------------------------
    //  resourceLoader
    //----------------------------------

    /**
     * Returns the <code>ResourceLoader</code> used to load localized strings.
     *
     * @return The <code>ResourceLoader</code> used to load localized strings.
     */
    @Override protected ResourceLoader getResourceLoader()
    {
        if (resourceLoader == null)
        {
            try
            {
                MessageBroker broker = FlexContext.getMessageBroker();
                resourceLoader = broker != null? broker.getSystemSettings().getResourceLoader()
                        : new PropertyStringResourceLoader();
            }
            catch (NoClassDefFoundError exception) // Could happen in client mode.
            {
                return new PropertyStringResourceLoader();
            }
        }

        return resourceLoader;
    }

    //----------------------------------
    //  rootCauseErrorMessage
    //----------------------------------


    public Object getRootCauseErrorMessage()
    {
        if (rootCause == null)
            return null;

        // FIXME: serialize number field.
        return rootCause instanceof MessageException?
                ((MessageException)rootCause).createErrorMessage() : rootCause;
    }

    //----------------------------------
    //  statusCode
    //----------------------------------

    protected int statusCode;

    /**
     * Returns the HTTP status code of the exception.
     *
     * @return The HTTP status code of the exception.
     */
    public int getStatusCode()
    {
        return statusCode;
    }

    /**
     * Sets the HTTP status code of the exception.
     *
     * @param statusCode The HTTP status code of the exception.
     */
    public void setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
    }

    //--------------------------------------------------------------------------
    //
    // Public Methods
    //
    //--------------------------------------------------------------------------

    /**
     * Creates an error message from the exception.
     *
     * @return The error message.
     */
    public ErrorMessage createErrorMessage()
    {
        ErrorMessage msg = new ErrorMessage();
        msg.faultCode = code != null? code : "Server.Processing";
        msg.faultString = message;
        msg.faultDetail = details;
        msg.rootCause = getRootCauseErrorMessage();
        if (extendedData != null)
            msg.extendedData = extendedData;
        if (statusCode != 0)
            msg.setHeader(Message.STATUS_CODE_HEADER, statusCode);
        return msg;
    }

    /**
     * Invoked at hinge-points in server processing where catch-all exception logging is performed.
     * This method uses <code>isLogged()</code> and <code>setLogged()</code> to avoid repeat logging
     * of the same exception and uses <code>getPreferredLogLevel()</code> which may be
     * overridden in subclasses to control the log level that the logging is output at.
     * The underlying exception stack traces are also conditionally included in log output
     * if the exception class allows it and this is determined by invoking <code>isLogStackTraceEnabled()</code>
     *
     * @param inboundMessage The inbound message that triggered an exception during processing.
     * @param outboundMessage The outbound <code>ErrorMessage</code>, which may be null depending on whether it has been generated
     *                        or not at the point this method is invoked.
     * @param logMessageIntro The beginning text for the log message, which may be null; default value is returned by <code>getDefaultLogMessageIntro()</code>.
     */
    public void logAtHingePoint(Message inboundMessage, ErrorMessage outboundMessage, String logMessageIntro)
    {
        if (!isLogged())
        {
            setLogged(true);

            short preferredLevel = getPreferredLogLevel();
            // If the preferred level is less than the current Log level; return early.
            if (preferredLevel < Log.getTargetLevel())
                return;

            // Construct core log output.
            StringBuffer output = new StringBuffer();
            output.append((logMessageIntro != null) ? logMessageIntro : getDefaultLogMessageIntro());
            output.append(this.toString());
            output.append(StringUtils.NEWLINE);
            output.append("  incomingMessage: ");
            output.append(inboundMessage);
            output.append(StringUtils.NEWLINE);
            if (outboundMessage != null)
            {
                output.append("  errorReply: ");
                output.append(outboundMessage);
                output.append(StringUtils.NEWLINE);
            }
            if (isLogStackTraceEnabled())
            {
                output.append(ExceptionUtil.exceptionFollowedByRootCausesToString(this));
                output.append(StringUtils.NEWLINE);
            }

            switch (preferredLevel)
            {
                case LogEvent.FATAL:
                {
                    Log.getLogger(LogCategories.MESSAGE_GENERAL).fatal(output.toString());
                    break;
                }
                case LogEvent.ERROR:
                {
                    Log.getLogger(LogCategories.MESSAGE_GENERAL).error(output.toString());
                    break;
                }
                case LogEvent.WARN:
                {
                    Log.getLogger(LogCategories.MESSAGE_GENERAL).warn(output.toString());
                    break;
                }
                case LogEvent.INFO:
                {
                    Log.getLogger(LogCategories.MESSAGE_GENERAL).info(output.toString());
                    break;
                }
                case LogEvent.DEBUG:
                {
                    Log.getLogger(LogCategories.MESSAGE_GENERAL).debug(output.toString());
                    break;
                }
                default:
                {
                    Log.getLogger(LogCategories.MESSAGE_GENERAL).fatal("Failed to log exception for handling message due to an invalid preferred log level: " + preferredLevel);
                    break;
                }
            }
        }
    }
}
