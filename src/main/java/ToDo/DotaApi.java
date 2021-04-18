package ToDo;

import com.ibasco.agql.protocols.valve.dota2.webapi.Dota2WebApiClient;
import com.ibasco.agql.protocols.valve.dota2.webapi.Dota2WebApiInterface;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Econ;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Match;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Stats;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.*;
import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiClient;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamEconPlayerAccountInfo;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class DotaApi {
    static org.slf4j.Logger log;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BasicConfigurator.configure();
        String token = "2864C57DD98B5163EEF62ACCCE5BFE92";
        Dota2WebApiClient dotaClient = new Dota2WebApiClient(token);
        SteamWebApiClient client = new SteamWebApiClient();
        client.setAuthToken(token);
        Dota2Econ econ = new Dota2Econ(client);
        Dota2Match matchInterface = new Dota2Match(client);
        //List<Dota2League> leagues = matchInterface.getLeagueListing().get();
        //System.out.println(leagues);
        System.out.println(matchInterface.getTopLiveGame(1).get());

        //gameItems.forEach(Dota2WebApiQueryEx::displayResult);
        //gameItems.forEach(Dota2WebApiQueryEx::displayResult);
        //SteamEconPlayerAccountInfo steamEconPlayerAccountInfo = new SteamEconPlayerAccountInfo();
        //Dota2RealtimeServerStats serverStats = statsInterface.getRealtimeStats(90105101693392898L).get();
        //log.info("Server Stats : {}", serverStats);
        //org.slf4j.
        Dota2Stats statsInterface = new Dota2Stats(client);
        Dota2RealtimeServerStats serverStats = statsInterface.getRealtimeStats(76561198100422430L).get();
        log.info("Server Stats : {}", serverStats);
    }
}
