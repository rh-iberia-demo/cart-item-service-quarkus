package org.sample;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Schema(title = "CartItem")
@JsonPropertyOrder({"id","quantity","origin_catalog","final_price"})
@Entity
public class CartItem extends PanacheEntityBase {

	@Schema(title="UUID of a Cart Item", readOnly=true )
	@JsonProperty("id")
	@Id
	private String id;
	
	@Schema(title="Quantity" )
	@JsonProperty("quantity")
	private int quantity;
	
	@Schema(title="Origin Catalog" )
	@JsonProperty("origin_catalog")
    private String originCatalog;

	@Schema(title="Final Price" )
	@JsonProperty("final_price")
    private Double finalPrice;
	
}