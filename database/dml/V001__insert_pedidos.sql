USE pedidos_db;

INSERT INTO pedido (
    cliente,
    sku,
    produto,
    quantidade,
    valor,
    status
) VALUES
      (
          'João Silva',
          'NOTEBOOK-001',
          'Notebook',
          1,
          3899.90,
          'CRIADO'
      ),
      (
          'Maria Souza',
          'MONITOR-LG-27',
          'Monitor LG 27"',
          2,
          1299.90,
          'CRIADO'
      ),
      (
          'Carlos Oliveira',
          'MOUSE-LOGITECH-MX3',
          'Mouse Logitech MX Master 3',
          1,
          499.90,
          'CRIADO'
      ),
      (
          'Ana Pereira',
          'TECLADO-KEYCHRON-K2',
          'Teclado Mecânico Keychron K2',
          1,
          689.90,
          'CRIADO'
      ),
      (
          'Fernanda Lima',
          'HEADSET-HYPERX-CLOUD2',
          'Headset HyperX Cloud II',
          1,
          399.90,
          'CRIADO'
      ),
      (
          'Ricardo Santos',
          'SSD-KINGSTON-1TB',
          'SSD Kingston 1TB NVMe',
          2,
          579.90,
          'CRIADO'
      ),
      (
          'Juliana Costa',
          'NOTEBOOK-LENOVO-THINKPAD',
          'Notebook Lenovo ThinkPad',
          1,
          5899.00,
          'CRIADO'
      ),
      (
          'Eduardo Martins',
          'WEBCAM-LOGITECH-C920',
          'Webcam Logitech C920',
          3,
          449.90,
          'CRIADO'
      ),
      (
          'Patrícia Almeida',
          'DOCK-DELL-USBC',
          'Dock USB-C Dell',
          1,
          899.00,
          'CRIADO'
      ),
      (
          'Roberto Ferreira',
          'MOUSE-001',
          'Mouse',
          2,
          120.00,
          'CRIADO'
      );