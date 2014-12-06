package com.example.elyseturner.howhappycanmyhourbe.activities.Activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.elyseturner.howhappycanmyhourbe.R;

/**
 * Created by elyseturner on 11/26/14.
 */
public class LoginActivity extends Activity {
    private static final String TAG = LoginActivity.class.getName();
    private EditText userName;
    private EditText passWord;
    private Button loginButton;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        prefs = getSharedPreferences("com.example.elyseturner.howhappycanmyhourbe", MODE_PRIVATE);

        userName = (EditText) findViewById(R.id.user_name);
        passWord = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login_button);

        userName.setText(prefs.getString("username", ""));
    }

    public void loginButtonClicked(View v) {
        final String userNameString = userName.getText().toString().trim();
        final String passwordString = passWord.getText().toString().trim();

        prefs.edit()
                .putString("username", userNameString)
                .apply();

        new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        }).start();

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                long timestamp = System.currentTimeMillis();
                HttpURLConnection urlConnection = null;
                try {
                    Uri oauthUrl = new Uri.Builder()
                            .scheme("http")
                            .authority("platform.fatsecret.com")
                            .appendPath("rest")
                            .appendPath("server.api")
                            .appendQueryParameter("format", "json")
                            .appendQueryParameter("method", "profile.getauth")
                            .appendQueryParameter("oauth_consumer_key", getString(R.string.api_key))
                            .appendQueryParameter("oauth_nonce", "randobrando")
                            .appendQueryParameter("oauth_signature_method", "HMAC-SHA1")
                            .appendQueryParameter("oauth_timestamp", "" + timestamp)
                            .appendQueryParameter("oauth_version", "1.0")
                            .appendQueryParameter("user_id", userNameString)
                            .build();

                    URL url = new URL(oauthUrl.toString());

                    Map<String, String> oauthParams = new HashMap<String, String>();

                    String consumerSecret = "c73d506cfe26483382f257ce1b853634";
                    String accessSecret = "5598cbaae35347d1b7f114e78a5ced89";

                    String oauthSignature = generateSignature("GET", url, oauthParams, null, consumerSecret + "&" + accessSecret);

                    String signedUrlStr = oauthUrl.toString() +
                            "&oauth_signature=" + oauthSignature;

                    Log.d(TAG, "Signed URL = " + signedUrlStr);

                    URL signedUrl = new URL(signedUrlStr);

                    urlConnection = (HttpURLConnection) signedUrl.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line;
                    while((line = reader.readLine()) != null) {
                        Log.d(TAG, line);
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } finally {
                    if(urlConnection != null) urlConnection.disconnect();
                }
            }

        }).start();
        //*/
    }

    /*
    private static String generateSignature(
            String httpMethod,
            URL url,
            Map<String, String> oauthParams,
            byte[] requestBody,
            String secret
    ) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
        // Ensure the HTTP Method is upper-cased
        httpMethod.toUpperCase();

        // Construct the URL-encoded OAuth parameter portion of the signature base string
        String encodedParams = normalizeParams(httpMethod, url, oauthParams, requestBody);

        // URL-encode the relative URL
        String encodedUri = "http%3A%2F%2Fplatform.fatsecret.com%2Frest%2Fserver.api";

        // Build the signature base string to be signed with the Consumer Secret
        String baseString = String.format("%s&%s&%s", httpMethod, encodedUri, encodedParams);

        Log.d(TAG, "Signature Base String = " + baseString);

        return computeHmac(baseString, secret);
    }

    private static String normalizeParams(
            String httpMethod,
            URL url,
            Map<String, String> oauthParams,
            byte[] requestBody
    ) throws UnsupportedEncodingException
    {

        // Use a new LinkedHashMap for the OAuth signature creation
        Map<String, String> kvpParams = new LinkedHashMap<String, String>();
        kvpParams.putAll(oauthParams);

        // Place any query string parameters into a key value pair using equals ("=") to mark
        // the key/value relationship and join each parameter with an ampersand ("&")
        if (url.getQuery() != null)
        {
            for(String keyValue : url.getQuery().split("&"))
            {
                String[] p = keyValue.split("=");
                kvpParams.put(URLEncoder.encode(p[0], "UTF-8"), URLEncoder.encode(p[1], "UTF-8"));
            }

        }

        // Include the body parameter if dealing with a POST or PUT request
        if ("POST".equals(httpMethod) || "PUT".equals(httpMethod))
        {
            String body = Base64.encodeBase64String(requestBody).replaceAll("\r\n", "");
            body = URLEncoder.encode(body, "UTF-8");
            kvpParams.put("body", URLEncoder.encode(body, "UTF-8"));
        }

        // Sort the parameters in lexicographical order, 1st by Key then by Value; separate with ("=")
        TreeMap<String,String> sortedParams = new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);
        sortedParams.putAll(kvpParams);

        // Remove unwanted characters and replace the comma delimiter with an ampersand
        String stringParams = sortedParams.toString().replaceAll("[{} ]", "");
        stringParams = stringParams.replace(",", "&");

        // URL-encode the equals ("%3D") and ampersand ("%26")
        String encodedParams = URLEncoder.encode(stringParams, "UTF-8");

        return encodedParams;
    }

    public static String computeHmac(String baseString, String key)
            throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException,  UnsupportedEncodingException
    {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secret = new SecretKeySpec(key.getBytes(), mac.getAlgorithm());
        mac.init(secret);
        byte[] digest = mac.doFinal(baseString.getBytes());
        byte[] result = Base64.encodeBase64(digest);

        return new String(result);
    }
    */
}
