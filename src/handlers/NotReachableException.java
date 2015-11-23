/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

/**
 *
 * @author saniin
 */
public class NotReachableException extends Exception{
    public NotReachableException(String address) {
        super("Server not reachable: " + address);
    }
    
    public NotReachableException() {
        super("Server not reachable");
    }
}
