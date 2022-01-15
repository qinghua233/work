public class Order_Change {
    public String Cno(int OrderNo){
        String sql="select CommodityNo from order_management_system where OrderNo="+OrderNo+";";
        return sql;
    }

    public String num(int num){
        String sql="select Commoditynum from order_management_system where OrderNo="+num+";";
        return sql;
    }

    public String beforenum(int Cno){
        String sql="select ComNum from Commodity where CommodityNo="+Cno+";";
        return sql;
    }

    public String update1(int Cno,int nNum,int beforenum){
        String sql="update Commodity set ComNum="+(beforenum+nNum)+" where CommodityNo="+Cno+"";
        return sql;
    }

    public String Price(int Cno){
        String sql="select ComPrice from Commodity where CommodityNo="+Cno+";";
        return sql;
    }

    public String update2(int OrderNo,int NewCno,int Newnum,double totalprice){
        String sql="update order_management_system set CommodityNo="+NewCno+",Commoditynum="+Newnum
                +",TotalPrice="+totalprice+" where OrderNO="+OrderNo+";";
        return sql;
    }

    public String update3(int NewCno,int beforenum,int Newnum){
        String sql="update Commodity set ComNum="+(beforenum-Newnum)+" where CommodityNo="+NewCno+";";
        return sql;
    }
}
