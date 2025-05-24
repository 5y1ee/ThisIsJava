@Configuration
@EnableWebSocket// 웹소켓 활성화
public class WebSocketConfig implements WebSocketConfigurer{

	@Autowired
	private DevLogWebSocketHandler devLogWebSocketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// WebSocketHandler를 추가
		registry.addHandler(devLogWebSocketHandler, "/chating");
	}
}