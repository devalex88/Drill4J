package com.epam.drill.plugins.coverage

import kotlinx.serialization.Serializable

@Serializable
data class JavaClass(
    val name: String,
    val path: String,
    val methods: Set<JavaMethod>
)

@Serializable
data class JavaMethod(
    val ownerClass: String,
    val name: String,
    val desc: String
)

@Serializable
data class CoverageBlock(
    val coverage: Double?,
    val classesCount: Int = 0,
    val methodsCount: Int = 0,
    val uncoveredMethodsCount: Int = 0
)

@Serializable
data class NewCoverageBlock(
    val methodsCount: Int = 0,
    val methodsCovered: Int = 0,
    val coverage: Double? = null
)

@Serializable
data class JavaClassCoverage(
    val name: String,
    val path: String,
    val coverage: Double,
    val totalMethodsCount: Int,
    val coveredMethodsCount: Int,
    val methods: List<JavaMethodCoverage>
)

@Serializable
data class JavaMethodCoverage(
    val name: String,
    val desc: String,
    val coverage: Double
)