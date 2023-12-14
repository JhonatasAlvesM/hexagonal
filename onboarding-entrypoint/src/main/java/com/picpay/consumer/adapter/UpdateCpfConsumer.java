    package com.picpay.consumer.adapter;


    import com.picpay.consumer.event.UpdateCpfEvent;
    import com.picpay.ports.in.UpdateCpfInputPort;
    import lombok.RequiredArgsConstructor;
    import org.springframework.context.annotation.Bean;
    import org.springframework.stereotype.Component;

    import java.util.function.Consumer;

    @Component
    @RequiredArgsConstructor
    public class UpdateCpfConsumer {

        private final UpdateCpfInputPort updateCpfInputPort;

        public void receive(UpdateCpfEvent updateCpfEvent){
            updateCpfInputPort.updateCpf(updateCpfEvent.getCpf(), updateCpfEvent.isValidCpf());
        }
        @Bean
        public Consumer<UpdateCpfEvent> updateCPF(){
            return this::receive;
        }
    }
