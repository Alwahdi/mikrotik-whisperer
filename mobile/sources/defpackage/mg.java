package defpackage;

import android.app.Activity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.discover.DiscoverAdapter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: mg  reason: default package */
public class mg {
    public static ArrayList<pg> a;

    /* renamed from: a  reason: collision with other field name */
    Activity f4351a;

    /* renamed from: a  reason: collision with other field name */
    private RecyclerView.Adapter f4352a;

    /* renamed from: a  reason: collision with other field name */
    private RecyclerView.LayoutManager f4353a;

    /* renamed from: a  reason: collision with other field name */
    private RecyclerView f4354a;

    /* renamed from: a  reason: collision with other field name */
    Thread f4355a;

    /* renamed from: a  reason: collision with other field name */
    public DatagramPacket f4356a;

    /* renamed from: a  reason: collision with other field name */
    public DatagramSocket f4357a;

    /* renamed from: a  reason: collision with other field name */
    boolean f4358a = true;
    Thread b;

    public mg(Activity context) {
        this.f4351a = context;
        a = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) this.f4351a.findViewById(R.id.my_recycler_view);
        this.f4354a = recyclerView;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4351a);
        this.f4353a = linearLayoutManager;
        this.f4354a.setLayoutManager(linearLayoutManager);
        DiscoverAdapter discoverAdapter = new DiscoverAdapter(a, this.f4351a);
        this.f4352a = discoverAdapter;
        this.f4354a.setAdapter(discoverAdapter);
    }

    public void f() {
        this.f4355a = new Thread(new nd0(this));
        this.b = new Thread(new ak0(this));
        c();
    }

    private boolean a(pg ajVar) {
        Iterator<pg> it = a.iterator();
        while (it.hasNext()) {
            pg ajVar2 = it.next();
            if (ajVar2.f().equalsIgnoreCase(ajVar.f()) && ajVar2.a().equalsIgnoreCase(ajVar.a())) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        try {
            this.f4357a = new DatagramSocket(5678);
            byte[] bArr = {0, 0, 0, 0};
            this.f4356a = new DatagramPacket(bArr, bArr.length, InetAddress.getByName("255.255.255.255"), 5678);
            this.f4355a.start();
            this.b.start();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        } catch (SocketException e22) {
            e22.printStackTrace();
        }
    }

    public void d() {
        byte[] bArr = new byte[160];
        while (this.f4358a) {
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                this.f4357a.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                pg ajVar = new pg(datagramPacket);
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
        this.f4352a.notifyItemInserted(a.size() + 1);
        this.f4352a.notifyDataSetChanged();
    }

    public void e() {
        this.f4358a = false;
        this.f4355a.interrupt();
        this.b.interrupt();
        this.f4357a.close();
        this.f4356a = null;
    }
}
