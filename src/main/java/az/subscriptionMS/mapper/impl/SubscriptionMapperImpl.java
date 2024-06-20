package az.subscriptionMS.mapper.impl;

import az.subscriptionMS.dto.SubscriptionDTO;
import az.subscriptionMS.mapper.SubscriptionMapper;
import az.subscriptionMS.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionMapperImpl {

    private SubscriptionMapper subscriptionMapper;

    @Autowired
    public SubscriptionMapperImpl(SubscriptionMapper subscriptionMapper){
        this.subscriptionMapper = subscriptionMapper;
    }

    public SubscriptionDTO getSubDtoFromSub(Subscription subscription){
        return subscriptionMapper.subToSubDto(subscription);
    }

    public Subscription getSubFromSubDto(SubscriptionDTO subscriptionDTO){
        return subscriptionMapper.subDtoToSub(subscriptionDTO);
    }

}
