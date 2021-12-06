package com.anti_captcha.Api;

import com.anti_captcha.AnticaptchaBase;
import com.anti_captcha.ApiResponse.TaskResultResponse;
import com.anti_captcha.Helper.DebugHelper;
import com.anti_captcha.IAnticaptchaTaskProtocol;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class AntiGateTask extends AnticaptchaBase implements IAnticaptchaTaskProtocol {
    private URL websiteUrl;
    private String templateName;
    private JSONObject variables;
    private String proxyAddress;
    private Integer proxyPort;
    private String proxyLogin;
    private String proxyPassword;

    public void setWebsiteUrl(URL websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setVariables(JSONObject variables) {
        this.variables = variables;
    }

    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public void setProxyLogin(String proxyLogin) {
        this.proxyLogin = proxyLogin;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    @Override
    public JSONObject getPostData() {
        JSONObject postData = new JSONObject();

        try {
            postData.put("type", "AntiGateTask");
            postData.put("websiteURL", websiteUrl.toString());
            postData.put("templateName", templateName);

            if (proxyAddress != null && proxyPort != null) {
                postData.put("proxyAddress", proxyAddress);
                postData.put("proxyPort", proxyPort);
            }
            if (proxyLogin != null && proxyPassword != null) {
                postData.put("proxyLogin", proxyLogin);
                postData.put("proxyPassword", proxyPassword);
            }
            if (variables != null) {
                postData.put("variables", variables);
            }

        } catch (JSONException e) {
            DebugHelper.out("JSON compilation error: " + e.getMessage(), DebugHelper.Type.ERROR);

            return null;
        }

        return postData;
    }

    @Override
    public TaskResultResponse.SolutionData getTaskSolution() {
        return taskInfo.getSolution();
    }
}
