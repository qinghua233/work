public class stock_with_goods {
    public String newstock_with_goods(String Cname,double Cprice,int Cnum){
    String sql="insert into Commodity (ComName,ComPrice,ComNum) values('"+Cname+"',"+Cprice+","+Cnum+");";
    return sql;
    }

    public String beforenum(int Cno){
        String sql="select ComNum from Commodity where CommodityNo="+Cno+";";
        return sql;
    }

    public String oldstock_with_goods(int Cno,int beforenum,int addnum){
        String sql="update Commodity set ComNum="+(beforenum+addnum)+" where CommodityNo="+Cno+";";
        return sql;
    }
}
