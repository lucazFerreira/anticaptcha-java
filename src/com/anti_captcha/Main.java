package com.anti_captcha;

import com.anti_captcha.Api.*;
import com.anti_captcha.Helper.DebugHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws InterruptedException, MalformedURLException, JSONException {
        exampleGetBalance();
        exampleImageToText();
        exampleRecaptchaV2();
        exampleRecaptchaV2Proxyless();
        exampleRecaptchaV3Proxyless();
        exampleRecaptchaV2Enterprise();
        exampleRecaptchaV2EnterpriseProxyless();
        exampleRecaptchaV3EnterpriseProxyless();
        exampleFuncaptcha();
        exampleFuncaptchaProxyless();
        exampleGeeTest();
        exampleGeeTestProxyless();
        exampleHCaptchaProxyless();
        exampleAntiGateTask();
    }


    private static void exampleGeeTest() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        GeeTest api = new GeeTest();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("https://auth.geetest.com/"));
        api.setWebsiteKey("b6e21f90a91a3c2d4a31fe84e10d0442");
        // you need to get a new "challenge" each time
        api.setWebsiteChallenge("cd0b3b5c33fb951ab364d9e13ccd7bf8");

        //optional parameters, read the documentation regarding this
        api.setGeetestApiServerSubdomain("optional.subdomain.api.geetest.com");
        api.setGeetestLib("{\"customlibs\":\"url-to-lib.js\"}");


        // proxy access parameters
        api.setProxyType(RecaptchaV2.ProxyTypeOption.HTTP);
        api.setProxyAddress("xx.xxx.xx.xx");
        api.setProxyPort(8282);
        api.setProxyLogin("login");
        api.setProxyPassword("password");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result CHALLENGE: " + api.getTaskSolution().getChallenge(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("Result SECCODE: " + api.getTaskSolution().getSeccode(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("Result VALIDATE: " + api.getTaskSolution().getValidate(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleGeeTestProxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        GeeTestProxyless api = new GeeTestProxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("https://auth.geetest.com/"));
        api.setWebsiteKey("b6e21f90a91a3c2d4a31fe84e10d0442");

        // you need to get a new "challenge" each time
        api.setWebsiteChallenge("cd0b3b5c33fb951ab364d9e13ccd7bf8");

        //optional parameters, read the documentation regarding this
        api.setGeetestApiServerSubdomain("optional.subdomain.api.geetest.com");
        api.setGeetestLib("{\"customlibs\":\"url-to-lib.js\"}");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result CHALLENGE: " + api.getTaskSolution().getChallenge(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("Result SECCODE: " + api.getTaskSolution().getSeccode(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("Result VALIDATE: " + api.getTaskSolution().getValidate(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleImageToText() throws InterruptedException {
        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("1234567890123456789012");
        api.setFilePath("captcha.jpg");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getText(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleRecaptchaV2Proxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        RecaptchaV2Proxyless api = new RecaptchaV2Proxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://http.myjino.ru/recaptcha/test-get.php"));
        api.setWebsiteKey("6Lc_aCMTAAAAABx7u2W0WPXnVbI_v6ZdbM6rYf16");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleHCaptchaProxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        HCaptchaProxyless api = new HCaptchaProxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://democaptcha.com/"));
        api.setWebsiteKey("51829642-2cda-4b09-896c-594f89d700cc");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleRecaptchaV3Proxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        RecaptchaV3Proxyless api = new RecaptchaV3Proxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://www.supremenewyork.com"));
        api.setWebsiteKey("6Leva6oUAAAAAMFYqdLAI8kJ5tw7BtkHYpK10RcD");
        api.setPageAction("testPageAction");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleRecaptchaV2() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        RecaptchaV2 api = new RecaptchaV2();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://http.myjino.ru/recaptcha/test-get.php"));
        api.setWebsiteKey("6Lc_aCMTAAAAABx7u2W0WPXnVbI_v6ZdbM6rYf16");
        api.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/52.0.2743.116");

        // proxy access parameters
        api.setProxyType(RecaptchaV2.ProxyTypeOption.HTTP);
        api.setProxyAddress("xx.xxx.xx.xx");
        api.setProxyPort(8282);
        api.setProxyLogin("login");
        api.setProxyPassword("password");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }


    private static void exampleRecaptchaV2Enterprise() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        RecaptchaV2Enterprise api = new RecaptchaV2Enterprise();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://http.myjino.ru/recaptcha/test-get.php"));
        api.setWebsiteKey("6Lc_aCMTAAAAABx7u2W0WPXnVbI_v6ZdbM6rYf16");
        api.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/52.0.2743.116");

        // proxy access parameters
        api.setProxyType(RecaptchaV2.ProxyTypeOption.HTTP);
        api.setProxyAddress("xx.xxx.xx.xx");
        api.setProxyPort(8282);
        api.setProxyLogin("login");
        api.setProxyPassword("password");

        JSONObject enterprisePayload = new JSONObject();
        try {
            enterprisePayload.put("s", "SOME_UNDOCUMENTED_TOKEN_VALUE");
        } catch (Exception e) {
            DebugHelper.out("JSON error: "+e.getMessage(), DebugHelper.Type.ERROR);
            return;
        }
        api.setEnterprisePayload(enterprisePayload);

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleRecaptchaV2EnterpriseProxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        RecaptchaV2EnterpriseProxyless api = new RecaptchaV2EnterpriseProxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://http.myjino.ru/recaptcha/test-get.php"));
        api.setWebsiteKey("6Lc_aCMTAAAAABx7u2W0WPXnVbI_v6ZdbM6rYf16");

        JSONObject enterprisePayload = new JSONObject();
        try {
            enterprisePayload.put("s", "SOME_UNDOCUMENTED_TOKEN_VALUE");
        } catch (Exception e) {
            DebugHelper.out("JSON error: "+e.getMessage(), DebugHelper.Type.ERROR);
            return;
        }
        api.setEnterprisePayload(enterprisePayload);

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleRecaptchaV3EnterpriseProxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        RecaptchaV3EnterpriseProxyless api = new RecaptchaV3EnterpriseProxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://www.supremenewyork.com"));
        api.setWebsiteKey("6Leva6oUAAAAAMFYqdLAI8kJ5tw7BtkHYpK10RcD");
        api.setPageAction("testPageAction");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getGRecaptchaResponse(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleGetBalance() {
        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("1234567890123456789012");

        Double balance = api.getBalance();

        if (balance == null) {
            DebugHelper.out("GetBalance() failed. " + api.getErrorMessage(), DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Balance: " + balance, DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleFuncaptcha() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        FunCaptcha api = new FunCaptcha();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://http.myjino.ru/funcaptcha_test/"));
        api.setWebsitePublicKey("DE0B0BB7-1EE4-4D70-1853-31B835D4506B");
        api.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116");

        //optional parameters, be careful!
        api.setApiSubdomain("custom-domain-api.arkoselabs.com");
        api.setDataBlob("{\"blob\":\"DATA_BLOB_VALUE_HERE\"}");

        // proxy access parameters
        api.setProxyType(RecaptchaV2.ProxyTypeOption.HTTP);
        api.setProxyAddress("xx.xxx.xx.xx");
        api.setProxyPort(8282);
        api.setProxyLogin("login");
        api.setProxyPassword("password");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getToken(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleFuncaptchaProxyless() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        FunCaptchaProxyless api = new FunCaptchaProxyless();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://http.myjino.ru/funcaptcha_test/"));
        api.setWebsitePublicKey("DE0B0BB7-1EE4-4D70-1853-31B835D4506B");

        //optional parameters, be careful!
        api.setApiSubdomain("custom-domain-api.arkoselabs.com");
        api.setDataBlob("{\"blob\":\"DATA_BLOB_VALUE_HERE\"}");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getToken(), DebugHelper.Type.SUCCESS);
        }
    }

    private static void exampleAntiGateTask() throws MalformedURLException, InterruptedException {
        DebugHelper.setVerboseMode(true);

        AntiGateTask api = new AntiGateTask();
        api.setClientKey("1234567890123456789012");
        api.setWebsiteUrl(new URL("http://antigate.com/logintest.php"));
        api.setTemplateName("Sign-in and wait for control text");

        JSONObject variables = new JSONObject();
        try {
            variables.put("login_input_css", "#login");
            variables.put("login_input_value", "the login");
            variables.put("password_input_css", "#password");
            variables.put("password_input_value", "the password");
            variables.put("control_text", "You have been logged successfully");
        } catch (Exception e) {
            DebugHelper.out("JSON exception: "+e.getMessage(), DebugHelper.Type.ERROR);
            return;
        }
        api.setVariables(variables);

//        api.setProxyAddress("xx.xxx.xx.xx");
//        api.setProxyPort(8282);
//        api.setProxyLogin("login");
//        api.setProxyPassword("password");


        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: ", DebugHelper.Type.SUCCESS);
            DebugHelper.out("Cookies: ", DebugHelper.Type.SUCCESS);
            DebugHelper.out(api.getTaskSolution().getCookies().toString(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("localStorage: ", DebugHelper.Type.SUCCESS);
            DebugHelper.out(api.getTaskSolution().getLocalStorage().toString(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("fingerprint: ", DebugHelper.Type.SUCCESS);
            DebugHelper.out(api.getTaskSolution().getFingerprint().toString(), DebugHelper.Type.SUCCESS);
            DebugHelper.out("url: ", DebugHelper.Type.SUCCESS);
            DebugHelper.out(api.getTaskSolution().getUrl(), DebugHelper.Type.SUCCESS);
        }
    }

}
