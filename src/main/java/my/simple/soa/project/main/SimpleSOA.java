package my.simple.soa.project.main;

import my.simple.soa.project.model.Goods;
import my.simple.soa.project.soap.WebserviceSEI;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class SimpleSOA {

    public static void main(String[] args) {
        testSOAPFromClient();
    }


    private static void testSOAPFromClient() {
        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WebserviceSEI.class);
        factoryBean.setAddress(soapServiceUrl);

        WebserviceSEI webserviceSEI = (WebserviceSEI) factoryBean.create();

        Goods result = webserviceSEI.getGoods();
        System.out.println("Result: " + result);
    }

}
