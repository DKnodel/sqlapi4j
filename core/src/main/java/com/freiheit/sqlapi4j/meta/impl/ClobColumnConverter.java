package com.freiheit.sqlapi4j.meta.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Scanner;

import org.h2.jdbc.JdbcClob;
import org.h2.util.IOUtils;

import com.freiheit.sqlapi4j.meta.ColumnConverter;
import com.freiheit.sqlapi4j.meta.DbType;

public class ClobColumnConverter implements ColumnConverter<String,Clob>{

    private int _sqlType;
    private String _sqlTypename;

    public ClobColumnConverter(final int sqlType, final String sqlTypename) {
        _sqlType = sqlType;
        _sqlTypename = sqlTypename;
    }

    @Override
    public Clob toDb(String value, DbType<String> clazz) {
        Clob clob;
        new JdbcClob(
        return;
    }

    @Override
    public String fromDb(Clob value, DbType<String> dbType) {

        if (value == null) {
            return null;
        }
        try {
            Reader reader = value.getCharacterStream();

            long length = value.length();
            if (length > Integer.MAX_VALUE) {
                //clob data is bigger than what fits in a string, use/implement streaming
                throw new IllegalArgumentException("clob is longer than string max length, actual length: " + length);
            }

            StringWriter writer = new StringWriter((int)length);

            IOUtils.copyAndCloseInput(reader, writer, length);
            return writer.toString();
        } catch (SQLException | IOException e) {
            throw new IllegalArgumentException("could not convert clob db value to string", e);
        }
    }

    @Override
    public int getSqlType() {
        return _sqlType;
    }

    @Override
    public String getSqlTypeDeclaration(DbType<String> dbType) {
        return _sqlTypename;
    }
}
