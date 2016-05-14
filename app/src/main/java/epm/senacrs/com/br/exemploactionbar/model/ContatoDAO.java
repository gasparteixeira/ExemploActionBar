package epm.senacrs.com.br.exemploactionbar.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import epm.senacrs.com.br.exemploactionbar.db.BancoDadosOpenHelper;

/**
 * Created by Gaspar <gaspar.teixeira@gmail.com> on 14/05/16.
 */
public class ContatoDAO {

    BancoDadosOpenHelper bdOpenHelper;

    public ContatoDAO(Context contexto)
    {
        bdOpenHelper = new BancoDadosOpenHelper(contexto);
    }

    public boolean inserir(Contato contato)
    {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());
        dados.put("email", contato.getEmail());
        boolean success = banco.insert("contato", null, dados) > 0;
        banco.close();
        return(success);
    }

    public boolean delete(Contato contato)
    {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();
        boolean sucesso=banco.delete("contato", "id=?",
                new String[]{contato.getId().toString()}) > 0;
        banco.close();
        return(sucesso);
    }

    public boolean update(Contato contato)
    {

        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());
        dados.put("email", contato.getEmail());
        boolean sucesso =banco.update("contato", dados, "id=?",
                new String[]{contato.getId().toString()})>0;
        banco.close();
        return(sucesso);
    }

    public List<Contato> getAll()
    {
        List<Contato> listaContatos = new ArrayList<Contato>();

        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();
        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone","email"},
                null, null, null, null, null);

        while(cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setId(cursor.getInt(cursor.getColumnIndex("id")));
            contato.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            contato.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            contato.setEmail(cursor.getString(cursor.getColumnIndex("email")));

            listaContatos.add(contato);
        }
        return(listaContatos);
    }

    public Contato getById(Integer id)
    {


        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();
        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone","email"},
                "id=?", new String[]{id.toString()},
                null, null, null);

        if(cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setId(cursor.getInt(cursor.getColumnIndex("id")));
            contato.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            contato.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            contato.setEmail(cursor.getString(cursor.getColumnIndex("email")));

            return(contato);
        }
        return(null);
    }
}
