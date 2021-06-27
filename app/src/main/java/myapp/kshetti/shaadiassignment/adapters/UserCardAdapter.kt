package myapp.kshetti.shaadiassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.shaadiassignment.databinding.UserProfileCardBinding
import myapp.kshetti.shaadiassignment.databinding.UserProfileRowBinding
import myapp.kshetti.trialapp.model.Results

class UserCardAdapter(val results: List<Results>, val function: (Results) -> Unit) :
    RecyclerView.Adapter<UserCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserProfileCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(results[position])
    }

    override fun getItemCount() = results.size

    inner class ViewHolder(val binding: UserProfileCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(profile: Results) {
            binding.apply {
                user = profile
                Glide.with(profileIV.context)
                    .load(profile.picture.large)
                    .into(profileIV)

                setAcceptanceView(profile.status)

                acceptFab.setOnClickListener {
                    profile.status = profile.status.xor(1)
                    function.invoke(profile)
                    setAcceptanceView(profile.status)
                }

            }
        }

        private fun UserProfileCardBinding.setAcceptanceView(status: Int) {
            if (status == 0){
                acceptFab.setImageResource(R.drawable.approved)
                statusText.setText(UserProfileAdapter.CONNECT_NOW)
            }
            else {
                acceptFab.setImageResource(R.drawable.ic_accept_tick)
                statusText.setText(UserProfileAdapter.CONNECTED)
            }
        }
    }
}
