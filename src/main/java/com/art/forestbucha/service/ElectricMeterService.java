/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.forestbucha.service;

import com.art.forestbucha.entity.ElectricMeter;
import com.art.forestbucha.entity.ElectricMeterList;
import com.art.forestbucha.log.Loggable;
import java.net.URI;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author artem
 */
@Loggable
@Path("/electric_meter")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class ElectricMeterService {
    
    @PersistenceContext(unitName = "h2test")
    private EntityManager em;
    
    @Context
    private UriInfo uriInfo;
    
    
    public ElectricMeter createElectricMeter (boolean addYardLighting, String note) {
        
        ElectricMeter eMeters = new ElectricMeter(UUID.randomUUID(), addYardLighting, note);
        
        return eMeters;
    }
    
    @POST
    public Response createElectricMeter(ElectricMeter electricMeter){
        if (electricMeter == null){
            throw new BadRequestException();
        }
        
        em.persist(electricMeter);
                
        URI emUri = uriInfo.getAbsolutePathBuilder().path(electricMeter.getId().toString()).build();
        return Response.created(emUri).build();
    }
    
    @GET
    @Path("{id}")
    public Response getElectricMeter(@PathParam("id") UUID id){
        
        ElectricMeter electricMeter = em.find(ElectricMeter.class, id);
        
        if (electricMeter == null)
            throw new NotFoundException();
        
        return Response.ok(electricMeter).build();
    }
    
    @GET
    public Response getElectricMeters(){
        
        TypedQuery<ElectricMeter> query = 
                em.createNamedQuery(ElectricMeter.FIND_ALL, ElectricMeter.class);
       
        ElectricMeterList list = new ElectricMeterList(query.getResultList());
        
        return Response.ok(list).build();
        
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteElectricMeter(@PathParam("id") UUID id){
        ElectricMeter electricMeter = em.find(ElectricMeter.class, id);
        
        if (electricMeter == null){
            throw new NotFoundException();
        }
        
        em.remove(electricMeter);
        return Response.noContent().build();
    }    
}
