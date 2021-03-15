package nl.vs.fuse.animalorder.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.camel.Body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "animalorder.Shipments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "order", "shipped", "shipDate" })
@NamedQueries({
		@NamedQuery(name = "getNotShippedOrders", query = "select s from  Shipment s where s.shipped = false")})
public class Shipment implements Serializable {
 
	private static final long serialVersionUID = -2851309334577696887L;

	@Id
	@JsonProperty("id")
	private Integer id;

	// https://stackoverflow.com/questions/3774198/org-hibernate-mappingexception-could-not-determine-type-for-java-util-list-at
	@ManyToOne
	@JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "Shipment_Order_fk_1"))
	@JsonProperty
	private Order order;
	
    @Column(name = "ship_date" )
	@JsonProperty
	private LocalDate shipDate;

	// @JsonIgnore
	// private String description;

	@JsonProperty
	private boolean shipped;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public LocalDate getShipDate() {
		return shipDate;
	}

	public void setShipDate(LocalDate shipDate) {
		this.shipDate = shipDate;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}
	
	public void setShippedTrue(@Body Shipment shipment) {
		shipment.setShipped(true);
		shipment.setShipDate(LocalDate.now());
	}
 

}