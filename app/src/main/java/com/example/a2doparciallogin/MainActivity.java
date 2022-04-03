package com.example.a2doparciallogin;



import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // defining our own password pattern
    private static final Pattern CONTRASEÑA_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");
    private TextInputLayout usuario;
    private TextInputLayout contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing email and password
        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
    }

    private boolean validateUsuario() {

        // Extract input from EditText
        String usuarioInput = usuario.getEditText().getText().toString().trim();

        // if the email input field is empty
        if (usuarioInput.isEmpty()) {
            usuario.setError("Field can not be empty");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(usuarioInput).matches()) {
            usuario.setError("Please enter a valid email address");
            return false;
        } else {
            usuario.setError(null);
            return true;
        }
    }

    private boolean validateContraseña() {
        String contraseñaInput = contraseña.getEditText().getText().toString().trim();
        // if password field is empty
        // it will display error message "Field can not be empty"
        if (contraseñaInput.isEmpty()) {
            contraseña.setError("Field can not be empty");
            return false;
        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!CONTRASEÑA_PATTERN.matcher(contraseñaInput).matches()) {
            contraseña.setError("Password is too weak");
            return false;
        } else {
            contraseña.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateUsuario() | !validateContraseña()) {
            return;
        }

        // if the email and password matches, a toast message
        // with email and password is displayed
        String input = "Email: " + usuario.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + contraseña.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();


    }
    public void IrAPantallaElegir (View view){
        Intent i = new Intent(this, PANTALLAELEGIR.class);
        startActivity(i);
    }
}