package az.subscriptionMS.model;

import az.subscriptionMS.model.e_num.PlanType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SUBSCRIPTION")
@ApiModel(value = "My Subscription Object",description = "My Subscription")
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@ApiModelProperty(value = "Subscription ID")
	private Long id;

	@Column(name = "SUPPLIER_ID")
	@ApiModelProperty(value = "Subscription Supplier ID")
	private Long supplierId;

	@Column(name = "PLAN_TYPE",nullable = false)
	@ApiModelProperty(value = "Subscription Plan Type (WEEKLY or MONTHLY)")
	@Enumerated(EnumType.STRING)
	private PlanType planType;
	
	@Column(name = "IS_ACTIVE")
	@ApiModelProperty(value = "Subscription Active status")
	private boolean isActive;

}
