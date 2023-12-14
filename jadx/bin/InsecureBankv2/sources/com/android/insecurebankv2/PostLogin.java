package com.android.insecurebankv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class PostLogin extends Activity {
    Button changepasswd_button;
    TextView root_status;
    Button statement_button;
    Button transfer_button;
    String uname;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);
        this.uname = getIntent().getStringExtra("uname");
        this.root_status = (TextView) findViewById(R.id.rootStatus);
        showRootStatus();
        this.transfer_button = (Button) findViewById(R.id.trf_button);
        this.transfer_button.setOnClickListener(new View.OnClickListener() {
            /* class com.android.insecurebankv2.PostLogin.AnonymousClass1 */

            public void onClick(View v) {
                PostLogin.this.startActivity(new Intent(PostLogin.this.getApplicationContext(), DoTransfer.class));
            }
        });
        this.statement_button = (Button) findViewById(R.id.viewStatement_button);
        this.statement_button.setOnClickListener(new View.OnClickListener() {
            /* class com.android.insecurebankv2.PostLogin.AnonymousClass2 */

            public void onClick(View v) {
                PostLogin.this.viewStatment();
            }
        });
        this.changepasswd_button = (Button) findViewById(R.id.button_ChangePasswd);
        this.changepasswd_button.setOnClickListener(new View.OnClickListener() {
            /* class com.android.insecurebankv2.PostLogin.AnonymousClass3 */

            public void onClick(View v) {
                PostLogin.this.changePasswd();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void showRootStatus() {
        if (doesSuperuserApkExist("/system/app/Superuser.apk") || doesSUexist()) {
            this.root_status.setText("Rooted Device!!");
        } else {
            this.root_status.setText("Device not Rooted!!");
        }
    }

    private boolean doesSUexist() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() == null) {
                if (process != null) {
                    process.destroy();
                }
                return false;
            } else if (process == null) {
                return true;
            } else {
                process.destroy();
                return true;
            }
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    private boolean doesSuperuserApkExist(String s) {
        if (Boolean.valueOf(new File("/system/app/Superuser.apk").exists()).booleanValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void changePasswd() {
        Intent cP = new Intent(getApplicationContext(), ChangePassword.class);
        cP.putExtra("uname", this.uname);
        startActivity(cP);
    }

    /* access modifiers changed from: protected */
    public void viewStatment() {
        Intent vS = new Intent(getApplicationContext(), ViewStatement.class);
        vS.putExtra("uname", this.uname);
        startActivity(vS);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            callPreferences();
            return true;
        } else if (id != R.id.action_exit) {
            return super.onOptionsItemSelected(item);
        } else {
            Intent i = new Intent(getBaseContext(), LoginActivity.class);
            i.addFlags(67108864);
            startActivity(i);
            return true;
        }
    }

    public void callPreferences() {
        startActivity(new Intent(this, FilePrefActivity.class));
    }
}
