package edu.csudh.demo1

import spock.lang.Specification

class MathUtilsTest extends Specification {

    def "test addition"() {
        given:
        def mathUtils = new MathUtils()

        when:
        def result = mathUtils.add(5, 3)

        then:
        result == 8
    }

    def "test subtraction"() {
        given:
        def mathUtils = new MathUtils()

        when:
        def result = mathUtils.subtract(10, 3)

        then:
        result == 7
    }

    def "test multiplication"() {
        given:
        def mathUtils = new MathUtils()

        when:
        def result = mathUtils.multiply(4, 6)

        then:
        result == 24
    }

    def "test division with valid input"() {
        given:
        def mathUtils = new MathUtils()

        when:
        def result = mathUtils.divide(input1, input2)

        then:
        (result != -1.0) == expected

        where:
        expected | input1 | input2
        false    | 2      | 0
        true     | 4      | 2
    }
}
