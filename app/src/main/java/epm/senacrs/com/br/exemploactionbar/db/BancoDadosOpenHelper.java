package epm.senacrs.com.br.exemploactionbar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gaspar <gaspar.teixeira@gmail.com> on 14/05/16.
 */
public class BancoDadosOpenHelper extends SQLiteOpenHelper {

    private static String nome="crudContato.db";
    private static String create="CREATE TABLE contato" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nome VARCHAR(50),"+
            "telefone VARCHAR(20),"+
            "email VARCHAR(30));";

    public BancoDadosOpenHelper(Context contexto) {
        super(contexto, nome, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        banco.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int versaoAntiga, int versaoNova) {
        banco.execSQL("DROP TABLE contato");

    }

}
