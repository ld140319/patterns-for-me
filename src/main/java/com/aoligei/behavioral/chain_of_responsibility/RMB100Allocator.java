package com.aoligei.behavioral.chain_of_responsibility;

/**
 * 100元分配器
 *
 * @author coder
 * @date 2022-07-19 14:10:53
 * @since 1.0.0
 */
public class RMB100Allocator extends AbstractPaperCurrencyAllocator {
    @Override
    protected void allocate(CurrencyRequest request) {
        if (request.getToAllocateAmount() >= 100) {
            int allocatedNum = request.getToAllocateAmount() / 100;
            int remainingAmount = request.getToAllocateAmount() % 100;
            request.addAllocated("100", allocatedNum, remainingAmount);
        }
        if (request.getToAllocateAmount() > 0 && nextAllocator != null) {
            nextAllocator.allocate(request);
        }
    }
}
