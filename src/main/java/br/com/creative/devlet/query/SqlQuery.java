package br.com.creative.devlet.query;

public class SqlQuery<T> extends QueryRepository<T>{

    private String select = "";
    private String from = "";
    private String where = "";
    private String having = "";
    private String orderBy = "";
    private String groupBy = "";
    private String limit = "";

    public SqlQuery select(String select){
        this.select = select;
        return this;
    }

    public SqlQuery from(String from){
        this.from = from;
        return this;
    }

    public SqlQuery where(String where){
        this.where = where;
        return this;
    }

    public SqlQuery having(String having){
        this.having = having;
        return this;
    }

    public SqlQuery orderBy(String orderBy){
        this.orderBy = orderBy;
        return this;
    }

    public SqlQuery groupBy(String groupBy){
        this.groupBy = groupBy;
        return this;
    }

    public SqlQuery limit(String limit){
        this.limit = limit;
        return this;
    }

    public SqlQuery filterableBy(Filter ...filters){
        return this;
    }


    public SqlQuery into (Class<T> into){
        setQuery(buildQuery());

        return this;
    }

    private String buildQuery(){
        return "";
    }
}
