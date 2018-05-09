package com.chiyi.designpattern.singleton;

/**
 * @author chiyi
 */
public class Client {

    public static void main(String[] args) {
        LoadBalancer balancer1 ,balancer2 ,balancer3 ,balancer4;
        balancer1 = LoadBalancer.getLoadBalancer();
        balancer2 = LoadBalancer.getLoadBalancer();
        balancer3 = LoadBalancer.getLoadBalancer();
        balancer4 = LoadBalancer.getLoadBalancer();

        if(balancer1==balancer2 && balancer1 == balancer3&& balancer1==balancer4){
            System.out.println("they are same instance");
        }

        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer1.addServer("Server 3");
        balancer1.addServer("Server 4");

        for(int i=0;i<10;i++){
            String server = balancer1.getServer();
            System.out.println("the working server :" + server);
        }
    }

}
