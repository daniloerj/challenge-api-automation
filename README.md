
# Test Customers API


## Estructura del Proyecto

```bash
challenge-api-automation/
├── src/                   # Código fuente
│   ├── test/       # test (casos de prueba automatizados)
│   │   └── java
│   ├── performance/                # Performance Test
│   │   └── load.js        # Archivo JS que contiene la prueba de carga
│   ├── docs/       # Documentos
│   │   └── TestCasesCustomerServices.pdf #(diseño de caso de pruebas)
│   │   └── PerformanceTestReport.pdf #(Resultados de prueba de performance)
└── README.md              # Documentación del proyecto
```

## Instalación

1. Instala las dependencias del proyecto:

   ```bash
   mvn install
   ```

## Ejecución de api testing


```bash
mvn clean verify
```

## Ejecucion de performance test
```bash
cd src
cd performance
k6 run load.js
```