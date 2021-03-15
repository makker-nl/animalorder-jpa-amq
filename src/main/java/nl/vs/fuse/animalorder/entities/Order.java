package nl.vs.fuse.animalorder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "animalorder.Orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "customer", "date", "value", "tax" })
@NamedQueries({
		@NamedQuery(name = "getOrder", query = "select o from Order o where o.id = :orderId")})
public class Order implements Serializable {
	private static final long serialVersionUID = 5851038813219503043L;

	@Id
	@JsonProperty("id")
	private Integer id;

	// https://stackoverflow.com/questions/3774198/org-hibernate-mappingexception-could-not-determine-type-for-java-util-list-at
	@ManyToOne
	@JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "Order_customer_fk_1"))
	@JsonProperty
	private Customer customer;

	@JsonProperty
	private Date date;

	// @JsonIgnore
	// private String description;

	@JsonProperty
	private double value;

	@JsonProperty
	private double tax;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

}