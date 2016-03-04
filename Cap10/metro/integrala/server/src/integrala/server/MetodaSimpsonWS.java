package integrala.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mathlib.client.cvadra.*;
import mathlib.client.cvadra.impl.MetodaSimpsonWeb;

/**
 *
 * @author SCHEIBER
 */
@WebService()
public class MetodaSimpsonWS {
  

  /**
   * Web service operation
   */
  @WebMethod(operationName = "integreaza")
  public DataOut integreaza(@WebParam(name = "a") String a, 
    @WebParam(name = "b") String b, 
    @WebParam(name = "svar") String svar,
    @WebParam(name = "expr") String expr, 
    @WebParam(name = "eps")  String eps, 
    @WebParam(name = "nmi")  String nmi) {
    //TODO write your implementation code here:
    JepDataIn din=new JepDataIn(svar,expr);
    din.setA(a);
    din.setB(b);
    din.setEps(Double.parseDouble(eps));
    din.setNmi(Integer.parseInt(nmi));
    IMetodaSimpson obj=new MetodaSimpsonWeb();
    DataOut dout=obj.metodaSimpson(din);
    return dout;
  }
}
