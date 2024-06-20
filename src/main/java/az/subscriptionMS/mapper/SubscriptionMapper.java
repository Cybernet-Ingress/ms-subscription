package az.subscriptionMS.mapper;

import az.subscriptionMS.dto.SubscriptionDTO;
import az.subscriptionMS.model.Subscription;

public interface SubscriptionMapper {

    SubscriptionDTO subToSubDto(Subscription subscription);
    Subscription subDtoToSub(SubscriptionDTO subscriptionDTO);
}
