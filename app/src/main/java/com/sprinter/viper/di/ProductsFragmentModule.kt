package com.sprinter.viper.di

import com.sprinter.viper.interact.ProductsInteract
import com.sprinter.viper.repository.products.ProductsRepository
import com.sprinter.viper.viewmodel.products.ProductsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ProductsFragmentModule {

    @Provides
    fun provideProductsViewModelFactory(
        ProductsInteract: ProductsInteract
    ): ProductsViewModelFactory =
        ProductsViewModelFactory(ProductsInteract)

    @Provides
    fun provideProductsInteract(productsRepository: ProductsRepository): ProductsInteract =
        ProductsInteract(productsRepository)
}
