package uk.me.eastmans.jwt.util;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import java.net.URI;

public class TestJWT {
    public static void main(String[] args) throws Exception {
        URI apiURI = new URI("http://my-jwt-demo-my-jwt-demo-bootable-jar-project.apps-crc.testing/" );
        RestClientBuilder restClientBuilder = RestClientBuilder.newBuilder();

        SampleEndPointService service = restClientBuilder
                .baseUri(apiURI)
                .build(SampleEndPointService.class);
        System.out.println( service.helloworld() );

        // We need to add the authorization aspect now
        String token = TokenUtil.generateJWT("Mark Eastman", "1960-10-08", "Echoer", "Subscriber" );
        String authorizationHeader = "Bearer " + token;

        System.out.println( service.helloRolesAllowed(authorizationHeader) );
        System.out.println( service.birthday(authorizationHeader) );
    }
}
