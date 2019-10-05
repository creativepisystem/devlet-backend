package br.com.creative.devlet.query;

enum SqlStatements {

    SELECT("select"),FROM("from"),WHERE("where"),AND("and"),OR("or"),
    HAVING("having"),ORDER_BY("order by"),GROUP_BY("group by"),LIMIT("limit");

    private String name;
    SqlStatements(String name){
        this.name = name;
    }
    protected String getName() {
        return name;
    }
}
