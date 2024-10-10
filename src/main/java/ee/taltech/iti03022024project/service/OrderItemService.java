package ee.taltech.iti03022024project.service;

import ee.taltech.iti03022024project.controller.OrderItemDto;
import ee.taltech.iti03022024project.mapstruct.OrderItemMapper;
import ee.taltech.iti03022024project.repository.OrderItemEntity;
import ee.taltech.iti03022024project.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public List<OrderItemDto> getOrderItems() {
        return orderItemRepository.findAll().stream().map(orderItemMapper::toDto).toList();
    }

    public Optional<OrderItemDto> getOrderItemById(int id) {
        return orderItemRepository.findById(id).map(orderItemMapper::toDto);
    }

    public Optional<OrderItemDto> createOrderItem(OrderItemDto orderItemDto) {
        OrderItemEntity newOrderItem = orderItemMapper.toEntity(orderItemDto);
        OrderItemEntity savedOrderItem = orderItemRepository.save(newOrderItem);
        return Optional.of(orderItemMapper.toDto(savedOrderItem));
    }


    public Optional<Object> deleteOrderItem(int id) {
        Optional<OrderItemEntity> orderItemToDelete = orderItemRepository.findById(id);
        orderItemToDelete.ifPresent(orderItemRepository::delete);
        return orderItemToDelete.map(orderItemMapper::toDto);
    }
}

