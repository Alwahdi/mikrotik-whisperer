package defpackage;

import android.app.Activity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.DiscoverAdapter;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ng  reason: default package */
public class ng {
    public static ArrayList<og> a;

    /* renamed from: a  reason: collision with other field name */
    Activity f4431a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayoutManager f4432a;

    /* renamed from: a  reason: collision with other field name */
    RecyclerView f4433a;

    /* renamed from: a  reason: collision with other field name */
    DiscoverAdapter f4434a;

    /* renamed from: a  reason: collision with other field name */
    Thread f4435a;

    /* renamed from: a  reason: collision with other field name */
    public DatagramPacket f4436a;

    /* renamed from: a  reason: collision with other field name */
    public DatagramSocket f4437a;

    /* renamed from: a  reason: collision with other field name */
    boolean f4438a = true;
    Thread b;

    public ng(Activity context) {
        this.f4431a = context;
        a = new ArrayList<>();
        this.f4433a = (RecyclerView) this.f4431a.findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4431a);
        this.f4432a = linearLayoutManager;
        this.f4433a.setLayoutManager(linearLayoutManager);
        DiscoverAdapter discoverAdapter = new DiscoverAdapter(a, this.f4431a);
        this.f4434a = discoverAdapter;
        this.f4433a.setAdapter(discoverAdapter);
        this.f4433a.setItemAnimator(new DefaultItemAnimator());
    }

    public void f() {
        this.f4435a = new Thread(new od0(this));
        this.b = new Thread(new bk0(this));
        c();
    }

    private boolean a(og ajVar) {
        Iterator<og> it = a.iterator();
        while (it.hasNext()) {
            og ajVar2 = it.next();
            if (ajVar2.f().equalsIgnoreCase(ajVar.f()) && ajVar2.a().equalsIgnoreCase(ajVar.a())) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        try {
            this.f4437a = new DatagramSocket(5678);
            byte[] bArr = {0, 0, 0, 0};
            this.f4436a = new DatagramPacket(bArr, bArr.length, InetAddress.getByName("255.255.255.255"), 5678);
            this.f4435a.start();
            this.b.start();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        } catch (SocketException e22) {
            e22.printStackTrace();
        }
    }

    public void e() {
        byte[] bArr = new byte[160];
        while (this.f4438a) {
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                this.f4437a.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                og ajVar = new og(datagramPacket);
                if (ajVar.c() && !a(ajVar) && datagramPacket.getLength() > 60) {
                    a.add(ajVar);
                    b();
                }
            } catch (SocketException e) {
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
    }

    public void b() {
        DiscoverAdapter discoverAdapter = new DiscoverAdapter(a, this.f4431a);
        this.f4434a = discoverAdapter;
        this.f4433a.setAdapter(discoverAdapter);
        this.f4434a.notifyDataSetChanged();
    }

    public void d() {
        this.f4438a = false;
        this.f4435a.interrupt();
        this.b.interrupt();
        this.f4437a.close();
        this.f4436a = null;
    }
}
