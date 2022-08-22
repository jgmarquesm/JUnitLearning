/*
Primeiramente, para construirmos uma Suite de Teste, precisamos adicionar uma dependencia ao pom.xml:

<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-suite-engine</artifactId>
    <version>1.8.1</version>
</dependency>

após isso devemos fazer o uso da Suite Annotation e importar as dependências.

Para customizar quais os testes queremos rodar com a Suite, temos à disposição as seguintes opções:

- @SelectClasses:
    Usamos quando queremos executar testes em determinadas Classes. Podemos executar uma classe ou várias:
        - Single Class:
            @Suite
            @SelectClasses(ClassA.class)
        - Multiples Classes:
            @Suite
            @SelectClasses(ClassA.class, ClassB.class, ..., ClassB.class)

- @SelectPackages:
    Usamos quando queremos executar testes que estão em determinados Packages. Podemos executar um pacote ou vários:
        - Single Package:
            @Suite
            @SelectPackages(examples.packageA)
        - Multiples Packages:
            @Suite
            @SelectPackages(examples.packageA, examples.packageB, ..., examples.packageZ)

- @IncludePackages
    Usamos para incluir Pacakges à Suite que quando foi usado o SelectPackages(...).
        - Single Package:
            @Suite
            @SelectPackages(examples)
            @IncludePackages(examples.packageA)
        - Multiples Packages:
            @Suite
            @SelectPackages(examples)
            @IncludePackages(examples.packageA, examples.packageB, examples.packageZ)

- @ExcludePackages
    Usamos para excluir Pacakges à Suite que quando foi usado o SelectPackages(...).
        - Single Package:
            @Suite
            @SelectPackages(examples)
            @ExcludePackages(examples.packageA)
        - Multiples Packages:
            @Suite
            @SelectPackages(examples)
            @ExcludePackages(examples.packageA, examples.packageB, examples.packageZ)

- @IncludeClassNamePatterns
    Usamos para incluir Classes, que tem o padrão de nome desejado, à Suite.
        @Suite
        @SelectPackages(examples)
        @IncludeClassNamePatterns(regex)

- @ExcludeClassNamePatterns
    Usamos para excluir Classes, que tem o padrão de nome desejado, à Suite.
        @Suite
        @SelectPackages(examples)
        @ExcludeClassNamePatterns(regex)

- @IncludeTags
    Usamos para incluir nos testes as classes que estão marcadas com aquela tag.
        @Suite
        @SelectPackages(examples)
        @IncludeTags("tag")

- @ExcludeTags
    Usamos para excluir nos testes as classes que estão marcadas com aquela tag.
        @Suite
        @SelectPackages(examples)
        @ExcludeTags("tag")
*/

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages({"com", "pilha.de"})
@IncludePackages({"pilha.de.livros", "com.calculadora", "com.retangulo"})
public class TestSuite {}
