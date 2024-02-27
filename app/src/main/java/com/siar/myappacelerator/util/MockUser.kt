package com.siar.myappacelerator.util

import com.siar.myappacelerator.domain.model.Address
import com.siar.myappacelerator.domain.model.Company
import com.siar.myappacelerator.domain.model.Geo
import com.siar.myappacelerator.domain.model.User

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 26/02/2024
 *
 *****/
@Suppress("MemberNameEqualsClassName")
object MockUser {
        val mockUser: User = User(
            id = 100,
            name = "Leanne Graham",
            username = "Bret",
            email = "Sincere@april.biz",
            address = Address(
                street = "Kulas Light",
                suite = "Apt. 556",
                city = "Gwenborough",
                zipcode = "92998-3874",
                geo = Geo(
                    lat = "-37.3159",
                    lng = "81.1496"
                )
            ),
            phone = "1-770-736-8031 x56442",
            website = "hildegard.org",
            company = Company(
                name = "Romaguera-Crona",
                catchPhrase = " Multi-layered client-server neural-net"
            )
        )
}

