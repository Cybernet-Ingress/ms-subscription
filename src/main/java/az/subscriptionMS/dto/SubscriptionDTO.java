package az.subscriptionMS.dto;

import az.subscriptionMS.model.e_num.PlanType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@ApiModel(value = "My Subscription Object",description = "My Subscription")
public class SubscriptionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Subscription ID")
	private Long id;

	@ApiModelProperty(value = "Subscription Supplier ID")
	private Long supplierId;

	@ApiModelProperty(value = "Subscription Plan Type (WEEKLY or MONTHLY)")
	@Enumerated(EnumType.STRING)
	private PlanType planType;

	@ApiModelProperty(value = "Subscription Active status")
	private boolean isActive;

}
