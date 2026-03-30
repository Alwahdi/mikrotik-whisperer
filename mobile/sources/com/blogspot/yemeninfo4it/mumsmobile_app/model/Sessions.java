package com.blogspot.yemeninfo4it.mumsmobile_app.model;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

public class Sessions {
    public String download;
    public String id;
    public String name;
    public String nas_port_id;
    public String price;
    public String st_from;
    public String upload;
    public String uptime;

    public Sessions(String name2, String st_from2, String price2, String nas_port_id2, String id2, String download2, String upload2, String uptime2) {
        this.name = name2;
        this.st_from = st_from2;
        this.price = price2;
        this.nas_port_id = nas_port_id2;
        this.id = id2;
        this.download = download2;
        this.upload = upload2;
        this.uptime = uptime2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getStfrom() {
        return this.st_from;
    }

    public void setStfrom(String st_from2) {
        this.st_from = st_from2;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price2) {
        this.price = price2;
    }

    public String getSt_from() {
        return this.st_from;
    }

    public void setSt_from(String st_from2) {
        this.st_from = st_from2;
    }

    public String getNas_port_id() {
        return this.nas_port_id;
    }

    public void setNas_port_id(String nas_port_id2) {
        this.nas_port_id = nas_port_id2;
    }

    public String getDownload() {
        return this.download;
    }

    public void setDownload(String download2) {
        this.download = download2;
    }

    public String getUpload() {
        return this.upload;
    }

    public void setUpload(String upload2) {
        this.upload = upload2;
    }

    public String getUptime() {
        return this.uptime;
    }

    public void setUptime(String uptime2) {
        this.uptime = uptime2;
    }

    public static class allScript extends AsyncTask<String, String, ArrayList<Sessions>> {
        /* access modifiers changed from: protected */
        @Nullable
        public ArrayList<Sessions> doInBackground(String... params) {
            ArrayList localArrayList = new ArrayList();
            try {
                j3 localApiConnection = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                localApiConnection.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (!localApiConnection.w()) {
                    return null;
                }
                for (Map localMap : localApiConnection.q("/tool/user-manager/session/print")) {
                    localArrayList.add(new Sessions(String.valueOf(localMap.get("user")), String.valueOf(localMap.get("from-time")), "", "", "", "", "", ""));
                }
                return localArrayList;
            } catch (Exception localException2) {
                try {
                    System.out.println("Error :" + localException2.toString());
                    return null;
                } catch (Exception e) {
                    return localArrayList;
                }
            }
        }
    }
}
