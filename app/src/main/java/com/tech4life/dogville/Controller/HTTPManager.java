package com.tech4life.dogville.Controller;

        import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

        import android.util.Base64;

public class HTTPManager
{
    // A method to get the data from the URI
    public static String getData(String uri)
    {

        BufferedReader reader = null;
        try
        {
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }

            return sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return null;
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public static String getData(String uri, String username, String password)
    {

        byte[] loginBytes = (username + ":" + password).getBytes();
        StringBuilder loginBuilder = new StringBuilder().append("Basic ").append(
                Base64.encodeToString(loginBytes, Base64.DEFAULT));

        HttpURLConnection con = null;

        BufferedReader reader = null;
        try
        {
            URL url = new URL(uri);
            con = (HttpURLConnection) url.openConnection();

            con.addRequestProperty("Authorization", loginBuilder.toString());
          con.setDoOutput(true);
            con.setRequestMethod("POST");
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }

            return sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                int status = con.getResponseCode();
            }
            catch (IOException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            return null;
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                     reader.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
