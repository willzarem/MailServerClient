/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

/**
 *
 * @author saniin
 */
public class ServerDomainNotAdded extends Exception {
    public ServerDomainNotAdded() {
        super("Server not added to the table");
        
    }
}
