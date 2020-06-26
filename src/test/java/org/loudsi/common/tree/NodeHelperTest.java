package org.loudsi.common.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class NodeHelperTest {
    private static class Foo {
        double value;

        public Foo(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    @Test
    void findMaxInLeafs() {
        Node<Foo> fooNode = new Node<>(
                new Foo(1),
                List.of(
                        new Node<>(
                                new Foo(6),
                                List.of(
                                        new Node<>(new Foo(1)),
                                        new Node<>(new Foo(12)),
                                        new Node<>(new Foo(0))
                                )),

                        new Node<>(new Foo(5),
                                List.of(
                                        new Node<>(new Foo(12)),
                                        new Node<>(new Foo(-2)),
                                        new Node<>(new Foo(13))
                                ))
                )
        );

        final Foo max = NodeHelper.findMax(fooNode, Comparator.comparing(Foo::getValue));
        Assertions.assertEquals(13D, max.getValue());


    }

    @Test
    void findMaxInBranch(){
        Node<Foo> secondNode = new Node<>(
                null,
                List.of(
                        new Node<>(
                                new Foo(6),
                                List.of(
                                        new Node<>(new Foo(1)),
                                        new Node<>(new Foo(12)),
                                        new Node<>(new Foo(0))
                                )),

                        new Node<>(new Foo(20),
                                List.of(
                                        new Node<>(new Foo(12)),
                                        new Node<>(new Foo(-2)),
                                        new Node<>(new Foo(13))
                                ))
                )
        );
        final Foo secondMax = NodeHelper.findMax(secondNode, Comparator.comparing(Foo::getValue));
        Assertions.assertEquals(20D, secondMax.getValue());
    }
    @Test
    void getAllLeafs() {

        Node<Foo> fooNode = new Node<>(
                new Foo(1),
                List.of(
                        new Node<>(
                                new Foo(6),
                                List.of(
                                        new Node<>(new Foo(1)),
                                        new Node<>(new Foo(12)),
                                        new Node<>(new Foo(0))
                                )),

                        new Node<>(new Foo(5),
                                List.of(
                                        new Node<>(new Foo(12)),
                                        new Node<>(new Foo(-2)),
                                        new Node<>(new Foo(13))
                                ))
                )
        );
        final List<Node<Foo>> allLeafs = NodeHelper.getAllLeafs(fooNode);
        Assertions.assertEquals(6, allLeafs.size());
    }
}