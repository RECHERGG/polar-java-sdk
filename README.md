# Polar.sh Java SDK

A community-driven Java SDK for integrating with the [Polar.sh](https://polar.sh) API. This SDK provides developers with a convenient and type-safe way to interact with Polar.sh services for digital product sales and subscription management.

> [!CAUTION]
> ### This Project is currently under development.

## 🚀 Features

- **Complete API Coverage**: Supports all major Polar.sh API endpoints
- **Asynchronous Operations**: Uses CompletableFuture for non-blocking API calls
- **Sandbox Support**: Built-in support for development and testing environments
- **Type-Safe**: Fully typed request and response objects
- **Builder Pattern**: Intuitive API with builder pattern for request objects
- **Lombok Integration**: Reduces boilerplate code with Lombok annotations
- **Comprehensive Testing**: Extensive integration tests included

## 🛠️ TODOs / Roadmap

- [ ] **Robust Error Handling**
- [ ] **Timeouts & Retries** 
- [ ] **Request Customization**
- [ ] **Logging Support** 
- [ ] **Rate Limit Awareness**
- [ ] **Metrics & Monitoring Hooks**
- [ ] **API Reference**
- [ ] **Maven Central Release**

## 📦 Installation

### Maven

```xml
<dependency>
    <groupId>de.rechergg</groupId>
    <artifactId>polar-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```kotlin
implementation("de.rechergg:polar-java-sdk:1.0.0")
```

## 🔧 Quick Start

### Client Initialization

```java
import de.rechergg.Polar;
import de.rechergg.PolarClient;

// Production environment
PolarClient client = Polar.sdk()
    .accessToken("your_access_token")
    .build();

// Sandbox environment (for testing and development)
PolarClient client = Polar.sdk()
    .accessToken("your_sandbox_access_token")
    .useSandbox(true)
    .build();
```

## 💡 Usage Examples

### Creating a Checkout Session

```java
import de.rechergg.models.checkout.request.CheckoutCreateRequest;
import java.util.concurrent.TimeUnit;

var request = CheckoutCreateRequest.builder()
    .productId("your-product-id")
    .build();

var response = client.coreApi()
    .checkoutService()
    .createCheckoutSession(request)
    .get(10, TimeUnit.SECONDS);

System.out.println("Checkout ID: " + response.id());
System.out.println("Status: " + response.status());
```

### Retrieving a Checkout Session

```java
import de.rechergg.models.checkout.request.CheckoutGetRequest;

var request = CheckoutGetRequest.builder()
    .checkoutId("checkout-session-id")
    .build();

var checkout = client.coreApi()
    .checkoutService()
    .getCheckoutSession(request)
    .get(10, TimeUnit.SECONDS);

System.out.println("Checkout Status: " + checkout.status());
```

## 🔒 Security

- **API Keys**: Keep your API keys secure and never commit them to version control
- **Environment Variables**: Use environment variables or secure configuration files for credentials
- **Sandbox**: Use the sandbox environment for development and testing

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 🆘 Support

- **Official Polar.sh Documentation**: [docs.polar.sh](https://docs.polar.sh)
- **Issues**: [GitHub Issues](https://github.com/RECHERGG/polar-java-sdk/issues)

## 🔗 Related Projects

- **Official Polar.sh JavaScript SDK**: [@polar-sh/sdk](https://github.com/polarsource/polar-js)
- **Official Polar.sh Python SDK**: [polar-python](https://github.com/polarsource/polar-python)
- **Polar.sh Platform**: [polarsource/polar](https://github.com/polarsource/polar)

## ⚠️ Disclaimer

This is a community-maintained SDK and is not officially supported by Polar.sh. For official SDKs, please check the [Polar.sh documentation](https://docs.polar.sh/integrate/sdk).

---

**Built with ❤️ by RECHERGG and the community for the Polar.sh ecosystem**
