package org.embulk.util.web_api.writer;

import com.fasterxml.jackson.databind.JsonNode;
import org.embulk.config.ConfigSource;
import org.embulk.spi.Column;
import org.embulk.spi.PageBuilder;

public class LongColumnWriter
        extends AbstractColumnWriter
{
    public LongColumnWriter(Column column, ConfigSource config)
    {
        super(column, config);
    }

    @Override
    public void write(JsonNode v, PageBuilder to)
    {
        if (v == null || v.isNull()) {
            to.setNull(column);
        }
        else {
            to.setLong(column, v.longValue());
        }
    }
}
