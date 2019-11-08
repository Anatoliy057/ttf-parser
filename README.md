# TTF Parsers on Java

## Usage

```java
    TTFParser parser = new TTFParser();
    parser.parse(ttfFile);
    Font font = parser.createFont();
    Glyph[] glyphs = font.getGlyphs("Hello world!");
```

## Supported tables:

- cmap
- glyf
- head
- hhea
- hmtx
- loca
- maxp
- hdmx

## Supported formats of encoding:

- 4

## Dependencies

- org.junit.jupiter
- log4j
- org.reflections


