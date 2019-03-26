package factory;

import dao.IAdmin_infoDAO;
import dao.ICome_back_infoDAO;
import dao.IExpress_infoDAO;
import dao.INight_back_infoDAO;
import dao.IRepairs_infoDAO;
import dao.IStudent_infoDAO;
import dao.proxy.Admin_infoDAOProxy;
import dao.proxy.Come_back_infoDAOProxy;
import dao.proxy.Express_infoDAOProxy;
import dao.proxy.Night_back_infoDAOProxy;
import dao.proxy.Repairs_infoDAOProxy;
import dao.proxy.Student_infoDAOProxy;

public class DAOFactory {  
	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}

    public static IAdmin_infoDAO getIAdmin_infoDAODAOInstance(){      // 取得DAO实例  
        return new Admin_infoDAOProxy();       // 返回代理实例  
    }  
    public static ICome_back_infoDAO getICome_back_infoDAOInstance(){      // 取得DAO实例  
        return new Come_back_infoDAOProxy();       // 返回代理实例  
    }  
    public static IExpress_infoDAO getIExpress_infoDAOInstance(){      // 取得DAO实例  
        return new Express_infoDAOProxy();       // 返回代理实例  
    }  
    public static INight_back_infoDAO getINight_back_infoDAOInstance(){      // 取得DAO实例  
    	return new Night_back_infoDAOProxy();       // 返回代理实例  
    }  
    public static IRepairs_infoDAO getIRepairs_infoDAOInstance(){      // 取得DAO实例  
    	return new Repairs_infoDAOProxy();       // 返回代理实例  
    }  
    public static IStudent_infoDAO getIStudent_infoDAOInstance(){      // 取得DAO实例  
    	return new Student_infoDAOProxy();      // 返回代理实例  
    }  
}  