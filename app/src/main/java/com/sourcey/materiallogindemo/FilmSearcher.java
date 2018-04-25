package com.sourcey.materiallogindemo;

import android.content.Intent;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FilmSearcher
{
    String key="AIzaSyAoMYUCd_08iv_lrClnWbfxSW-6DSCSyNU";

    public String searchNetflix(String s) throws Exception
    {
        ArrayList<String> list = new ArrayList();
        boolean foundFlag = false;
        String foundLink = "";

        s = s.replaceAll(" ", "+");

        String qry = "Netflix+" + s;
        URL url = new URL(
                "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ qry + "&alt=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;

        while ((output = br.readLine()) != null)
        {
            if(output.contains("\"link\": \""))
            {
                String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
                list.add(link);
            }
        }

        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).startsWith("https://www.netflix.com/title/"))
            {
                foundFlag = true;
                foundLink = list.get(i);
            }
        }

        conn.disconnect();

        if(foundFlag == true)
        {
            return foundLink;
        }
        else
        {
            return "";
        }

    }

    public String searchHulu(String s) throws Exception
    {
        ArrayList<String> list = new ArrayList();
        boolean foundFlag = false;

        String foundLink = "";

        String orig = "";

        s = s.replaceAll(" ", "+");

        String qry = "Hulu+" + s;
        URL url = new URL(
                "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ qry + "&alt=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;

        while ((output = br.readLine()) != null)
        {
            if(output.contains("\"link\": \""))
            {
                String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
                list.add(link);
            }
        }

        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).startsWith("https://www.hulu.com/" + orig.toLowerCase()))
            {
                foundFlag = true;
                foundLink = list.get(i);
            }
        }

        conn.disconnect();

        if(foundFlag == true)
        {
            return foundLink;
        }
        else
        {
            return "";
        }
    }
}