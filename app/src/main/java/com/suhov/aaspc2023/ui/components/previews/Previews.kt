package com.suhov.aaspc2023.ui.components.previews

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
	name = "Phone",
	group = "Devices",
	showSystemUi = true,
	device = Devices.PIXEL
)
annotation class PhonePreview

@Preview(
	name = "Tablet",
	group = "Devices",
	showSystemUi = true,
	device = Devices.TABLET
)
annotation class TabletPreview

@PhonePreview
@TabletPreview
annotation class DevicesPreview

@Preview(
	name = "Element",
	group = "Element",
	showSystemUi = false,
)
annotation class ElementPreview