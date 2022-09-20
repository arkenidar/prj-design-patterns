public class QueryBuilder {
    private String select;
    private String from;
    private String where;

    public static void main(String[] args) {
        System.out.println(new QueryBuilder().select("*").from("mysql").where("true"));
    }

    public QueryBuilder select(String select) {
        this.select = select;
        return this;
    }

    public QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    public QueryBuilder where(String where) {
        this.where = where;
        return this;
    }

    @Override
    public String toString() {
        return String.format("SELECT %s FROM %s WHERE %s ;", select, from, where);
    }
}
