package cloud.juancamp.aws.marshaller;

import cloud.juancamp.aws.dto.response.PingInformationDTO;
import cloud.juancamp.aws.model.PingInformationModel;
import cloud.juancamp.aws.utils.Marshaller;
import org.springframework.stereotype.Component;

@Component
public class PingInformationMarshaller implements Marshaller<PingInformationModel, PingInformationDTO> {

    public PingInformationDTO marshall(PingInformationModel input) {
        PingInformationDTO pingInformationDTO = new PingInformationDTO();

        pingInformationDTO.setMessage(input.getPingMessage());
        pingInformationDTO.setDetails(
                input.getSystemInformation(),
                input.getSystemPerformance(),
                input.getSystemTime(),
                input.getSystemStatus()
        );

        return pingInformationDTO;
    }

    @Override
    public Class<PingInformationModel> getInputClass() {
        return PingInformationModel.class;
    }
}
